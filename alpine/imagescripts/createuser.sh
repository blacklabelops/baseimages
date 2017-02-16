#!/bin/bash

set -o errexit

readonly CUR_DIR=$(cd $(dirname ${BASH_SOURCE:-$0}); pwd)

source $CUR_DIR/dockeruser.sh

dockerUser
printUserInfo
