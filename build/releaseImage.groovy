/**
 * Jenkins 2.0 Buildfile
 **/

def pushImages(dockerRepositories,dockerImageName,dockerTags,branchName) {
  stage 'Repository-Push'
  for (int i=0;i < dockerTags.length;i++) {
      dockerPush(dockerImageName,dockerTags[i],branchName,dockerRepositories[0][0])
  }
}

/**
 * Docker needs three parameters to work, I distributed those Credentials inside
 * two Jenkins-UsernamePassword Credentials.
 * Credentials 'Dockerhub' with Dockerhub username and password
 * Credentials 'DockerhubEmail' with the email inside the password field.
 **/
def repositoryLogin(remoteRepository,credentialsAId,credentialsBId) {
  echo 'Login to Dockerhub with Credentials Dockerhub and DockerhubEmail'
  withCredentials([[$class: 'UsernamePasswordMultiBinding',
    credentialsId: credentialsAId,
    usernameVariable: 'USERNAME',
    passwordVariable: 'PASSWORD']]) {
    withCredentials([[$class: 'UsernamePasswordMultiBinding',
      credentialsId: credentialsBId,
      usernameVariable: 'DUMMY',
      passwordVariable: 'EMAIL']]) {
      sh 'docker login --email $EMAIL --username $USERNAME --password $PASSWORD ' + remoteRepository
    }
  }
}

def dockerPush(imageName, tagName, branchName, remoteRepository) {
    def branchSuffix = branchName?.trim() ? '-' + branchName : ''
    def repositoyToken = remoteRepository?.trim() ? remoteRepository + '/' : ''
    def image = remoteRepository + imageName + ':' + tagName + branchSuffix
    sh 'docker push ' + image
}

return this;
