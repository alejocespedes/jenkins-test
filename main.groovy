#!/bin/bash

def funcion (){
    echo "respuesta de groovy ${params.PERSON}"
    echo "respuesta de groovy ${params.NOMBRE}"
}

def remote(){
    sshpass -p tcuser ssh docker@192.168.30.100 'docker exec -it ubuntu bash' && 'ls -lrt'
}
 return this