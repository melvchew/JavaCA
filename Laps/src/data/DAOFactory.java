package data;

public class DAOFactory {

	public static AccessLevelDAO getAccessLevel() {
		return new AccessLevelDAOImpl();
	}

	public static DefaultLeaveDAO getDefaultLeave() {
		return new DefaultLeaveDAOImpl();
	}

	public static HolidaysDAO getHolidaysDAOInstance() {
		return new HolidaysDAOImpl();
	}

	public static LeaveAppnDAO getLeaveAppn() {
		return new LeaveAppnDAOImpl();
	}

	public static LeaveDAO getLeave() {
		return new LeaveDAOImpl();
	}

	public static LeaveTypeDAO getLeaveType() {
		return new LeaveTypeDAOImpl();
	}

	public static OtClaimsDAO getOtClaims() {
		return new OtClaimsDAOImpl();
	}

	public static PositionDAO getPosition() {
		return new PositionDAOImpl();
	}

	public static UsersDAO getUsers() {
		return new UsersDAOImpl();
	}

}
