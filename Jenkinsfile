pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {

        stage('Build'){
            steps {
                // for prod env
                bat "mvn -Dusername=${username} -Dpassword=${password}  clean install -DskipTests"
            }
        }
//         stage('Deploy'){
//             steps {
//                    bat "java -cp C:\\Users\\DELL\\IdeaProjects\\java-api\\1.0-SNAPSHOT\\java-api-1.0-SNAPSHOT.jar oim.neplab.UserManagement"
//             }
//         }
    }
}
