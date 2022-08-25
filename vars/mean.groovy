def call(ip,credId,user){
  sshagent([credId]) {
    // copy war
    sh "scp -o StrictHostKeyChecking=no target/myweb-0.0.9.war ${user}@${ip}:/opt/tom9/webapps"
    // stop tomcat
    sh "ssh ${user}@${ip} /opt/tom9/bin/shutdown.sh"
    // start tomcat
    sh "ssh ${user}@${ip} /opt/tom9/bin/startup.sh"
  }
}
