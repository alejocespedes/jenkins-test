def funcion (){
    echo "respuesta de groovy ${params.PERSON}"
    echo "respuesta de groovy ${params.NOMBRE}"
}

def getRemote () {
    withCredentials([usernamePassword(credentialsId: 'ubuntu', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')])
        def remote = [:]
        remote.name = 'remote'
        remote.host = "${params.HOST}"
        remote.user = "$USERNAME"
        remote.password = "$PASSWORD"
        remote.allowAnyHosts = true

        return remote
}   

def comandos(){
  def remote = getRemote()
  sshCommand remote: remote, command: 'docker exec ubuntu bin/sh -c "cd /home && . ./prueba.sh"'
}

 return this