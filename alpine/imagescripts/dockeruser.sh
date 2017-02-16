#!/bin/bash

set -o errexit

function createDockerUserGroup {
  local groupname=$1
  local groupid=$2
  addgroup -g $groupid $groupname
}

function createDockerUser {
  local username=$1
  local userid=$2
  local groupname=$3
  adduser -G $groupname -s /bin/bash -u $userid -h /home/$username -S $username
}

function dockerUser {
  createDockerUserGroup $CURRENT_DOCKER_GROUP $CURRENT_DOCKER_GROUP_ID
  createDockerUser $CURRENT_DOCKER_USER $CURRENT_DOCKER_USER_ID $CURRENT_DOCKER_GROUP
}

function printUserInfo {
    echo "Docker User: "$(id $CURRENT_DOCKER_USER)
}

function dockerUserInit {
  local default_user=$1
  local default_user_id=$2
  local default_group=$3
  local default_group_id=$4
  DOCKER_DEFAULT_USER=${default_user:-blacklabelops}
  DOCKER_DEFAULT_USER_ID=${default_user_id:-1000}
  DOCKER_DEFAULT_GROUP=${default_group:-blacklabelops}
  DOCKER_DEFAULT_GROUP_ID=${default_group_id:-1000}

  CURRENT_DOCKER_USER=${DOCKER_USER:-$DOCKER_DEFAULT_USER}
  CURRENT_DOCKER_USER_ID=${DOCKER_USER_ID:-$DOCKER_DEFAULT_USER_ID}
  CURRENT_DOCKER_GROUP=${DOCKER_USERGROUP:-$DOCKER_DEFAULT_GROUP}
  CURRENT_DOCKER_GROUP_ID=${DOCKER_USERGROUP_ID:-$DOCKER_DEFAULT_GROUP_ID}
}

dockerUserInit $1 $2 $3 $4
