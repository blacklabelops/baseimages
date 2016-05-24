/**
 * Jenkins 2.0 Buildfile
 **/

 def getBranchName() {
   def branchName = env.JOB_NAME.replaceFirst('.+/', '')
   echo 'Building on Branch: ' + branchName
   def tagPostfix = ''
   if (branchName != null && !'master'.equals(branchName)) {
      tagPostfix = branchName
   }
   return tagPostfix
 }

def buildJobCI(dockerWorkspace,dockerImageName,dockerTags,dockerTestCommands,dockerImages,branchName) {
  stage 'Refresh Images'
  for (int i=0;i < dockerImages.length;i++) {
    pullImage(dockerImages[i])
  }

  stage 'Build Image'
  echo 'Building Images'
  for (int i=0;i < dockerTags.length;i++) {
    buildImage(dockerWorkspace,dockerImageName,dockerTags[i],branchName)
  }

  stage 'Test Image'
  echo 'Testing Images'
  for (int i=0;i < dockerTags.length;i++) {
    testImage(dockerImageName,dockerTags[i],branchName,dockerTestCommands)
  }
}

def pullImage(imageName) {
  echo 'Refreshing image: ' + imageName
  sh 'docker pull ' + imageName
}

def testImage(imageName, tagName, branchName,dockerCommands) {
  def branchSuffix = branchName?.trim() ? '-' + branchName : ''
  def image = imageName + ':' + tagName + branchSuffix
  for (int i=0;i < dockerTestCommands.length;i++) {
    echo 'Testing image: ' + image
    sh 'docker run --rm ' + image + ' ' + dockerTestCommands[i]
  }
}

def buildImage(dockerWorkspace, imageName, tagName, branchName) {
  def branchSuffix = branchName?.trim() ? '-' + branchName : ''
  def image = imageName + ':' + tagName + branchSuffix
  echo 'Building image: ' + image
  sh 'cd ' + dockerWorkspace + ' && docker build --no-cache -t ' + image + ' .'
}

return this;
