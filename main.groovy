def funcion (){
    echo "respuesta de groovy ${params.PERSON}"
    echo "respuesta de groovy ${params.NOMBRE}"
}

def getRemote () {
        def remote = [:]
        remote.name = 'remote'
        remote.host = "${params.HOST}"
        remote.user = "docker"
        remote.password = "tcuser"
        remote.allowAnyHosts = true

        return remote
}   

def comandos(){
  def remote = getRemote()
  sshCommand remote: remote, command: 'docker exec ubuntu bin/sh -c "cd /home && . ./prueba.sh"'
}

 return this