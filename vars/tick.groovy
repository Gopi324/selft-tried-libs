def call(id,ip,u){
  sshagent([id]) {
    // copy war file
    sh "scp -o StrictHostKeyChecking=no target/myweb-0.0.9.war ${u}@${ip}:/opt/tom9/webapps"
    // stop tomcat
    sh "ssh ${u}@${ip} /opt/tom9/bin/shutdown.sh"
    // start tomcat
    sh "ssh ${u}@${ip} /opt/tom9/bin/startup.sh"
  }
}
