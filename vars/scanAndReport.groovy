def call(String severity, boolean fullScan) {
    script {
        def tag = sh(returnStdout: true, script: 'cat VERSION').trim()
        echo "Scanning Docker image: demo-app:${tag} with severity level: ${severity}"
        
        // Run scan (replace with your actual scanning tool command)
        def scanCmd = "scan_tool --image demo-app:${tag} --severity ${severity}"
        if (fullScan) {
            scanCmd += " --full-scan"
        }

        sh scanCmd
    }
}
