#!/bin/bash

STATUS=$1

curl "http://localhost:8080/status/$STATUS"
