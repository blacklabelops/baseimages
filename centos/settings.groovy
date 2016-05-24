/**
 * Jenkins 2.0 Buildfile
 **/

/**
 * Build parameters, must be adjusted when forked!
 **/
dockerImageName = 'blacklabelops/centos'
dockerWorkspace = 'centos/'
dockerTags = ["latest","7","7.2","7.2.1511"] as String[]
dockerTestCommands =
 ["echo hello world",
  "ps -All",
  "uname -r",
  "whoami",
  "cat /etc/hosts",
  "cat /etc/passwd"] as String[]
dockerRepositories = [["","Dockerhub","DockerhubEmail"]] as String[][]
dockerImages = ["centos:7.2.1511"] as String[]

return this;
