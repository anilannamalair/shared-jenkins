def call() {
    script {
        echo "Publishing Docker image..."
        
        // Ensure the image tag is retrieved
        def tag = sh(returnStdout: true, script: 'cat VERSION').trim()

        // Login to Docker registry (modify as needed)
        sh "docker login -u \$DOCKER_USER -p \$DOCKER_PASS"

        // Tag and push image
        sh "docker tag demo-app:${tag} my-registry.com/demo-app:${tag}"
        sh "docker push my-registry.com/demo-app:${tag}"

        echo "Docker image demo-app:${tag} published successfully!"
    }
}
