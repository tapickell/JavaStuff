void int main(int argc, const char* argv[]){

	getReadyForShift();

	if(!timeToClockIn) {
	    wait
	}
	else {
 	   clockIn();
	}

	while(!timeToClockOut) {
		work();
	}
}

void work() {
	if(!callsInQue) {
   	 	readHomework
   	}
	else {
    	takeCall();
    }
}


void getReadyForShift() {
	connect to VPN
	start Ticket / VNC software
	log into email
	log into tennant and team chat rooms
	log into time clock site
}

void takeCall() {
	if(!callerPaidForService) {
        transferToSalesDept
    }
    else {
        determineProblem
        establishRemoteConnection
        if(problemIsVirus) {
             doVirusRemovalProcess
        }
        else if(problemIsHelpdesk) {
             troubleshootIssue
    	}
        else {
             troubleshootWirelessNetwork
        }
        resolveIssues
    	RestoreFunctionalityToPc
    	callCustomerBack
    	demonstrateProblemFixed
    	endCall
    }
}