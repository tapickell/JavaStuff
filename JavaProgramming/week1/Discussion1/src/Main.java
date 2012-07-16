import java.sql.Time;
import javax.swing.JDialog;

/**
 * @author Todd Pickell CISS 238
 *         3/19/12
 *         Programming Discussion 1
 */
public class Main
{
	/**
	 * fields for time constants
	 */
	private static int timeToClockIn = 600;
	private static int timeToClockOut = 1430;

	/**
	 * main method
	 */
	public static void main(String[] args) {
		getReadyForShift();

		if(Time < timeToClockIn) {
			wait;
		}
		else {
			clockIn;
		}

		while(Time < timeToClockOut) {
			work();
		}
		clockOut;
	}

	/**
	 * get ready for my shift method
	 */
	private static void getReadyForShift() {
		connect to VPN;
		start Ticket / VNC software;
		log into email;
		log into tennant and team chat rooms;
		log into time clock site;
	}

	/**
	 * work loop method
	 * done until time to clock out is reached
	 */
	private static void work() {
		if(!callsInQue) {
			readHomeworkAssignment;
		}
		else {
			takeCall();
		}
	}

	/**
	 * take call method
	 * used to establish if work is done
	 * for client and what type of
	 * service to perform on computer
	 */
	private static void takeCall() {
		/**
		 * all services are paid for
		 * if they dont pay dont waste
		 * time transfer them back to isp
		 */
		if(!callerPaidForService) {
			if (wantToPay) {
				transferToSalesDept;
			}
			else {
				transferToIsp;
			}
		}
		else {
			determineProblem
					establishRemoteConnection;
			if(problemIsVirus) {
				virusRemovalProcess;
			}
			else if(problemIsHelpdesk) {
				troubleshootPcIssue;
			}
			else {
				troubleshootWirelessNetwork;
			}
			resolveIssues;
			demonstrateProblemsFixed ;
			endCall;
		}
	}

}
