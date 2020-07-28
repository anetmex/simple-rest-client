#!/usr/bin/groovy
import groovy.json.JsonSlurper
try {
    List<String> artifacts = new ArrayList<String>()
    def artifactsUrl = "http://10.0.1.117:443/v2/simple-rest-app_1.0/tags/list"
    def artifactsObjectRaw = ["curl", "-s", "-H", "accept: application/json", "-k", "--url", "${artifactsUrl}"].execute().text
    def jsonSlurper = new JsonSlurper()
    def artifactsJsonObject = jsonSlurper.parseText(artifactsObjectRaw)
    def dataArray = artifactsJsonObject.tags
    for(item in dataArray){
        artifacts.add(item)
    }
    return artifacts
} catch (Exception e) {
    print "There was a problem fetching the artifacts"
}
