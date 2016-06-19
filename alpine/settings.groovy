/**
 * Jenkins 2.0 Buildfile
 **/

/**
 * Build parameters, must be adjusted when forked!
 **/
dockerImageName = 'blacklabelops/alpine'
dockerWorkspace = 'alpine/'
dockerTags = ["latest","3.4"] as String[]
dockerTestCommands =
 ["echo hello world",
  "ps -All",
  "uname -r",
  "whoami",
  "cat /etc/hosts",
  "cat /etc/passwd"] as String[]
dockerRepositories = [["","Dockerhub","DockerhubEmail"]] as String[][]
dockerImages = ["alpine:3.4"] as String[]

return this;
