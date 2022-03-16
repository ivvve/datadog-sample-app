#!/bin/bash

KEY=$1
VALUE=$2

curl "http://localhost:8080/db?key=$KEY&value=$VALUE"
