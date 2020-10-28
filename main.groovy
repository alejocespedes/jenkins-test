def funcion (){
    echo "respuesta de groovy ${params.PERSON}"
    echo "respuesta de groovy ${params.NOMBRE}"
}

def downloadfile(){
    sh "cd /tmp && curl -L https://github.com/alejocespedes/jenkins-test/tarball/91f8a47fa9ff9db455bf1b152c49646ccaff4a59 | tar xz"
}

def copyfiletodest(){
    sh "curl --insecure --user docker:tcuser -T /tmp/alejocespedes-jenkins-test-91f8a47/test.groovy sftp://192.168.30.100/tmp/"
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
  sshCommand remote: remote, command: "docker cp /tmp/test.groovy ubuntu:/tmp"
  // sshCommand remote: remote, command: 'docker exec ubuntu bin/sh -c "cd /home && . ./prueba.sh"'
}

 return this