def remote = [:] 
    remote.name = "ec2-user"
    remote.host = "3.17.205.180"
    remote.allowAnyHosts = true

pipeline{
    
    agent any
  
    tools{
        maven 'Maven3'
        terraform 'Terraform'
    }
    
    environment{
       // registry = "ijatingarg/firstwebapp"
        registry = "876724398547.dkr.ecr.us-east-2.amazonaws.com/jatin-docker-repo"
        registryCredential = "dockerhub_id"
        dockerImage = ''
    }
  
    stages{
        
        stage('Checkout'){
            steps{
              checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'Github_whojatingarg', url: 'https://github.com/whojatingarg/FlightSearchApplication']]])
            }
        }
        
        stage('Build'){
            steps{
                    bat 'mvn clean install'
            }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
            post{
                always{
                    
                    jacoco()
                    junit keepLongStdio: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }
    //     stage('Code Quality'){
    //         steps{
    //             withSonarQubeEnv('SonarQube Server'){
    //                 bat 'mvn sonar:sonar'
    //             }
                
    //         }
    //     }
    //     stage('Upload'){
    //       steps{
    //           rtMavenDeployer(
    //               id: 'deployer',
    //               serverId: SERVER_ID,
    //               releaseRepo: 'declarative-job-release-repo-local',
    //               snapshotRepo: 'declarative-job-repo-local'
    //           )
    //           rtMavenRun (
    //               pom: 'pom.xml',
    //               goals: 'clean install',
    //               deployerId: 'deployer',
    //           )
    //       }
    //     }
        
    //     stage ('Publish build info') {
    //         steps {
    //             rtPublishBuildInfo (
    //                 serverId: SERVER_ID
    //             )
    //         }
    //     }

    //     stage('Build Image')
    //     {
    //     steps
    //         {
    //          bat "docker build -t ${registry}:${BUILD_NUMBER} ."
    //         }
    //     }
        
          
    //     stage('Image push to ECR'){
    //         steps{
    //              withAWS(credentials : 'aws-key'){
    //                      bat 'aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.us-east-2.amazonaws.com'
    //                      bat  "docker push ${registry}:${BUILD_NUMBER}"
    //                  }
                     
    //         }
    //     }
        
    //  stage('terraform init'){
    //      steps{
    //          bat 'terraform init'
    //      }
    //  }
    
    //  stage('terraform plan'){
    //      steps{
    //          withAWS(credentials: 'aws-key'){
    //               bat 'terraform plan'
    //          }
           
    //      }
    //  }
    
    //  stage('terraform apply'){
    //      steps{
    //         withAWS(credentials: 'aws-key'){
    //             bat 'terraform apply -auto-approve'
    //         }
    //      }
    //  }
    
    // stage('Pre Container Check on EC2'){
        
    //     steps{
            
    //         withCredentials([sshUserPrivateKey(credentialsId: 'AWSLinuxSSH', keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: 'userName')]) {
           
    //         script{
    //             remote.user = userName
    //             remote.identityFile = identity
           
    //             //sshCommand remote : remote, command: 'aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.us-east-2.amazonaws.com'
    
    //             sshCommand remote : remote, command: 'sudo service docker start'
              
    //             sshCommand remote : remote, command: 'sudo docker ps -f name=webappcontainer -q | xargs --no-run-if-empty sudo docker container kill'
    //             sshCommand remote : remote, command: 'sudo docker container ls -a -f name=webappcontainer -q | xargs -r sudo docker container rm'

    //             }
    //         }
    //     }

    // }
    
          
    // stage('Container Deploy on EC2'){
        
    //     steps{
            
    //         withCredentials([sshUserPrivateKey(credentialsId: 'AWSLinuxSSH', keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: 'userName')]) {
           
    //         script{
    //             remote.user = userName
    //             remote.identityFile = identity
           
    //             //sshCommand remote : remote, command: 'aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.us-east-2.amazonaws.com'
               
    //             sshCommand remote : remote, command: 'sudo docker pull ijatingarg/firstwebapp:73'
    //             sshCommand remote : remote, command: 'sudo docker run --name webappcontainer -d -p 6060:8080 ijatingarg/firstwebapp:73'

    //             }
    //         }
    //     }

    // }
        
    }
}
