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
  sshCommand remote: remote, command: "docker exec -it ubuntu bash"
  sshCommand remote: remote, command: "cd /home"
  println('ejecuto comando')
  sshScript remote: remote, script: "prueba.sh"
}

 return this