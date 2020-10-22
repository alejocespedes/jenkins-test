def funcion (){
    echo "respuesta de groovy ${params.PERSON}"
    echo "respuesta de groovy ${params.NOMBRE}"
}

def getRemote () {
    withCredentials([usernamePassword(credentialsId: 'ubuntu', passwordVariable: 'password', usernameVariable: 'userName')]) {
        def remote = [:]
        remote.name = 'remote'
        remote.host = "${params.HOST}"
        remote.user = userName
        remote.password = password
        remote.allowAnyHosts = true

        return remote
    }   
}

def comandos(){
  def remote = getRemote()
  sshCommand remote: remote, command: 'docker exec ubuntu bin/sh -c "cd /home && . ./prueba.sh"'
}

def downloadfile(){
    ["git", "clone", "${params.URL}"].execute()
}
 return this