The demo application implementing apache camel to create integrations. This one fetches weather information for a given city using open-meteo

How ro run:

NOTE: all this was done on a Windows machine with Docker Desktop + WSL2 combination so some of this might not apply to you.
- clone the repo
- build the docker image "docker build -t entercamel", note that the container name must exactly be entercamel since that's what kubernetes is looking for.
- make sure your cluster is up and running and create deployment and service by running "kubectl apply -f k8s/".
- Since Kubernetes included with DD behaves like it does in Windows, you need to enable port-forwaring in order to access the app. run "kubectl port-forward deployment/enter-camel-deployment 8080:8080".

Now the app should be reachable at http://localhost:8080. Then make a post request to http://localhost:8080/process with json payload containing name and city.
For example: curl -H "Content-Type: application/json;charset=UTF-8" -X POST -d '{"name":"RoachZeus", "city":"Helsinki"}' http://localhost:8080/process.
You should receive a json response containing fields name, city, currentTemperature and time.

If for example you're on linux and running minikube then kubectl command might not be the right one, but I'm sure you know how to deploy etc. with the yaml files under k8s folder.
If so, then the app should be reachable through port 30080. You can find this under service.yaml as it's using type NodePort and it is defined as nodePort: 30080 under ports section.
