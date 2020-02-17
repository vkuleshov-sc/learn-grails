package testgrails

class UserCounterJob {

    def mailService
    def searchService

    static triggers = {
        simple repeatInterval: 300000,  startDelay:10000
    }

    def execute() {
        mailService.sendMail {
            to "iam@testgrails.com"
            subject "User count"
            text "User count: ${searchService.getTotalAmount()}"
        }
    }
}
