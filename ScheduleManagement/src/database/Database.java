package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	static Connection conn = null;
    static Statement stmt = null;
    static String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    static String USER = "sys as sysdba";
    static String PASS = "Khushi0521";
    
    public static void createConnection() {
    	try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
 
            if (conn != null) {
                System.out.println("Connected to the Oracle DB!");
                stmt=conn.createStatement();
            } else {
                System.out.println("Failed to make connection!");
            }
 
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @SuppressWarnings("finally")
	public static int addblock(String blockId, String blockName) {
    	int res=0;
    	String sql = "INSERT INTO BLOCK VALUES(\'"+blockId+"\', \'"+blockName+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }
    
    public static int addclassroom(String classroomId, String hasprojector,String Blockid) {
    	int res=0;
    	String sql = "INSERT INTO CLASSROOM VALUES(\'"+classroomId+"\', \'"+hasprojector+"\', \'"+Blockid+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }
    
    public static int addfaculty(String facultyId, String facultyname,String facultyemail,String phonenumber, String deptid) {
    	int res=0;
    	String sql = "INSERT INTO FACULTY VALUES(\'"+facultyId+"\', \'"+facultyname+"\', \'"+facultyemail+"\', \'"+phonenumber+"\', \'"+deptid+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }

    public static int adddepartment(String deptId, String deptName) {
    	int res=0;
    	String sql = "INSERT INTO DEPARTMENT VALUES(\'"+deptId+"\', \'"+deptName+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }
    
    public static int addsubject(String subcode, String subname,String subabbrevation) {
    	int res=0;
    	String sql = "INSERT INTO SUBJECT VALUES(\'"+subcode+"\', \'"+subname+"\', \'"+subabbrevation+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }
    
    public static int addhandles(String subcode, String facultyid) {
    	int res=0;
    	String sql = "INSERT INTO HANDLES VALUES(\'"+subcode+"\', \'"+facultyid+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }
    
    public static int addsection(String sectionId, String secname,String sem,String academicyear,String facultyid) {
    	int res=0;
    	String sql = "INSERT INTO SECTION VALUES(\'"+sectionId+"\', \'"+secname+"\', \'"+sem+"\', \'"+academicyear+"\', \'"+facultyid +"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }
    
    public static int addbatch(String secId, String BatchName) {
    	int res=0;
    	String sql = "INSERT INTO BATCH VALUES(\'"+secId+"\', \'"+BatchName+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }
    
    public static String[] deptIds() {
    	String query="SELECT DEPT_ID, DEPT_NAME FROM DEPARTMENT";
    	String[] depts = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			depts=new String[rs.getFetchSize()];
			int i=0;
			while(rs.next()) {
				depts[i]=rs.getString("DEPT_ID");
				
			}
			System.out.println(depts);
			//System.out.println(rs.getArray("DEPT_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return depts;}
    	
    }
    
    public static String[] facultyids() {
    	String query="SELECT FACULTY_ID FROM FACULTY";
    	String[] fids = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			fids=new String[rs.getFetchSize()];
			int i=0;
			while(rs.next()) {
				fids[i]=rs.getString("FACULTY_ID");
				System.out.println(fids[i]);
			}
			System.out.println(fids);
			//System.out.println(rs.getArray("DEPT_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return fids;}
    }
    
    public static String[] sections() {
    	String query="SELECT SEC_ID  FROM SECTION";
    	String[] secs = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			secs=new String[rs.getFetchSize()];
			int i=0;
			while(rs.next()) {
				secs[i]=rs.getString("SEC_ID");
				System.out.println(secs[i]);
			}
			System.out.println(secs);
			//System.out.println(rs.getArray("DEPT_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return secs;}
    }
    
    public static String[] subjects() {
    	String query="SELECT SUB_CODE  FROM SUBJECT";
    	String[] secs = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			secs=new String[rs.getFetchSize()];
			int i=0;
			while(rs.next()) {
				secs[i]=rs.getString("SUB_CODE");
				System.out.println(secs[i]);
			}
			System.out.println(secs);
			//System.out.println(rs.getArray("DEPT_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return secs;}
    }
    
    public static String[] blks() {
    	String query="SELECT BLOCK_ID  FROM BLOCK";
    	String[] secs = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			secs=new String[rs.getFetchSize()];
			int i=0;
			while(rs.next()) {
				secs[i]=rs.getString("BLOCK_ID");
				System.out.println(secs[i]);
			}
			System.out.println(secs);
			//System.out.println(rs.getArray("DEPT_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return secs;}
    }
    
    public static String[] clrs() {
    	String query="SELECT CLASSROOM_ID  FROM CLASSROOM";
    	String[] secs = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			secs=new String[rs.getFetchSize()];
			int i=0;
			while(rs.next()) {
				secs[i]=rs.getString("CLASSROOM_ID");
				System.out.println(secs[i]);
			}
			System.out.println(secs);
			//System.out.println(rs.getArray("DEPT_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return secs;}
    }
    
    public static String[][] getTT(String dept_id,String faculty_id){
    	String query="SELECT SUB_CODE,SEC_ID,CLASSROOM_ID,BLOCK_ID,DAYY,TIMEE,DURATIONN"+
    				" FROM CLASS_OR_LAB"+
    				" WHERE FACULTY_ID=\'"+faculty_id+"\'";
    	String classes[][] = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			classes=new String[rs.getFetchSize()][7];
			int i=0;
			while(rs.next()) {
				classes[i][0]=rs.getString("SUB_CODE");
				classes[i][1]=rs.getString("SEC_ID");
				classes[i][2]=rs.getString("CLASSROOM_ID");
				classes[i][3]=rs.getString("BLOCK_ID");
				classes[i][4]=rs.getString("DAYY");
				classes[i][5]=rs.getString("TIMEE");
				classes[i][6]=rs.getString("DURATION");
				//System.out.println(classes[i]);
			}
			System.out.println(classes);
			//System.out.println(rs.getArray("DEPT_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return classes;}
    }
    
    public static String[][] getSecTT(String dept_id,String section_id){
    	String query="SELECT SUB_CODE,FACULTY_ID,CLASSROOM_ID,BLOCK_ID,DAYY,TIMEE,DURATIONN"+
				" FROM CLASS_OR_LAB"+
				" WHERE SEC_ID=\'"+section_id+"\'";
	String classes[][] = null;
	try {
		ResultSet rs=stmt.executeQuery(query);
		classes=new String[rs.getFetchSize()][7];
		int i=0;
		while(rs.next()) {
			classes[i][0]=rs.getString("SUB_CODE");
			classes[i][1]=rs.getString("FACULTY_ID");
			classes[i][2]=rs.getString("CLASSROOM_ID");
			classes[i][3]=rs.getString("BLOCK_ID");
			classes[i][4]=rs.getString("DAYY");
			classes[i][5]=rs.getString("TIMEE");
			classes[i][6]=rs.getString("DURATION");
			//System.out.println(classes[i]);
		}
		System.out.println(classes);
		//System.out.println(rs.getArray("DEPT_ID"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {return classes;}
}
    
    public static String[][] freeClassRooms(String day, String time){
    	String query="SELECT CLASSROOM_ID,HAS_PROJECTOR,BLOCK_ID"+
    				" FROM CLASSROOM"+
    				" WHERE CLASSROOM_ID IN ( (SELECT CLASSROOM_ID"+
    										" FROM CLASSROOM)"+
    										" EXCEPT"+
    										" {SELECT CLASSROOM_ID"+
    										" FROM CLASS_OR_LAB"+
    										" WHERE DAYY=\'"+day+"\' "+
    										" AND TIMEE=\'"+time+"\'))";
    	String classr[][] = null;
    	try {
    		ResultSet rs=stmt.executeQuery(query);
    		classr=new String[rs.getFetchSize()][3];
    		int i=0;
    		while(rs.next()) {
    			classr[i][0]=rs.getString("CLASSROOM_ID");
    			classr[i][1]=rs.getString("HAS_PROJECTOR");
    			classr[i][2]=rs.getString("BLOCK_ID");
    			//System.out.println(classes[i]);
    		}
    		System.out.println(classr);
    		//System.out.println(rs.getArray("DEPT_ID"));
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}finally {return classr;}
    }
    
    public static void closeAll() {
    	try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
            e.printStackTrace();
        } 
        
    }
}
