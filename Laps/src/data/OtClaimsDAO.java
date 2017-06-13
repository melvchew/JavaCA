package data;

import java.util.ArrayList;

import model.OtClaimsDTO;
import model.UsersDTO;

public interface OtClaimsDAO {

	public void insertOtClaims(OtClaimsDTO dto) throws DAOException;
	public void updateOtClaims(OtClaimsDTO dto) throws DAOException;
	public void deleteOtClaims(OtClaimsDTO dto) throws DAOException;
	public ArrayList<OtClaimsDTO> getAllOtClaims() throws DAOException;
	public ArrayList<OtClaimsDTO> getOtClaims(UsersDTO user) throws DAOException;
	public ArrayList<OtClaimsDTO> getPendingOtClaims() throws DAOException;
	
}
