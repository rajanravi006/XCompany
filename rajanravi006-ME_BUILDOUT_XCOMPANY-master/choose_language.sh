#!/bin/bash
# Author : Yakshit Jain
# Copyright (c) Crio.Do
# Script follows here:

PS3="Select your programming language please: "

select opt in Java Python; do

  case $opt in
    Java)
    python3 setup.py ./__CRIO__/metadata.json JAVA
      break
      ;;
    Python)
    python3 setup.py ./__CRIO__/metadata.json PYTHON
      break
      ;;
    *) 
      echo "Invalid option $REPLY"
      ;;
  esac
done

