def funcion (){
    echo "respuesta de groovy ${params.PERSON}"
    echo "respuesta de groovy ${params.NOMBRE}"
}

def getRemote () {
        def remote = [:]
        remote.name = 'remote'
        remote.host = "192.168.30.100"
        remote.user = "docker"
        remote.password = "tcuser"
        remote.allowAnyHosts = true

        return remote
}   

def comandos(){
  println('ejecuto comando 1')
  def remote = getRemote()
  println('ejecuto comando 2')
  sshCommand remote: remote, command: 'docker exec ubuntu bash sh -c "cd /home && . ./prueba.sh"'
  println('ejecuto comando')
  
}

 return this