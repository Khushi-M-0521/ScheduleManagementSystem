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
    	String sql = "INSERT INTO BLOCKK VALUES(\'"+blockId+"\', \'"+blockName+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
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
    
    public static int addfaculty(String facultyId, String facultyname,String phonenumber, String facultyemail, String designation,String deptid) {
    	int res=0;
    	String sql = "INSERT INTO FACULTY VALUES(\'"+facultyId+"\', \'"+facultyname+"\', \'"+phonenumber+"\', \'"+facultyemail+"\', \'"+designation+"\', \'"+deptid+"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
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
    
    public static int addhandles(String subcode, String facultyid, String section_id, String batch_id) {
    	int res=0;
    	String sql = "INSERT INTO HANDLES VALUES(\'"+facultyid+"\', \'"+section_id+"\', \'"+subcode+"\', \'"+batch_id+"\')";
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
    
    public static int addclass(String[] handler, String classr, String blk, String day, String time, String duration) {
    	int res=0;
    	String sql = "INSERT INTO CLASS_OR_LAB VALUES(\'"+handler[0]+"\', \'"+handler[1]+"\', \'"+handler[2]+"\', \'"+classr+"\', \'"+blk +"\', \'"+day +"\', \'"+time +"\', \'"+duration +"\')";
    	try {
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally {
			return res;
		}
    }

//    public static int addbatch(String secId, String BatchName) {
//    	int res=0;
//    	String sql = "INSERT INTO BATCH VALUES(\'"+secId+"\', \'"+BatchName+"\')";
//    	try {
//			res=stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			res=-1;
//			e.printStackTrace();
//		}finally {
//			return res;
//		}
//    }
    
    public static String[] deptIds() {
    	String query="SELECT DEPT_ID FROM DEPARTMENT ORDER BY DEPT_ID";
    	String[] depts = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()) i++;
			depts=new String[i];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
			while(rs.next()) {
				depts[i]=rs.getString("DEPT_ID");
				i++;
			}
			System.out.println(depts);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return depts;}
    	
    }
    
    public static String[] facultyids() {
    	String query="SELECT FACULTY_ID FROM FACULTY ORDER BY FACULTY_ID";
    	String[] fids = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()) i++;
			fids=new String[20];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
			while(rs.next()) {
				fids[i]=rs.getString("FACULTY_ID");
				System.out.println(fids[i]);
				i++;
			}
			System.out.println(fids);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return fids;}
    }
    
    public static String[] sections() {
    	String query="SELECT SEC_ID  FROM SECTION ORDER BY SEC_ID";
    	String[] secs = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()) i++;
			secs=new String[i];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
			while(rs.next()) {
				secs[i]=rs.getString("SEC_ID");
				System.out.println(secs[i]);
				i++;
			}
			System.out.println(secs);
			return secs;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String[] subjects() {
    	String query="SELECT SUB_CODE  FROM SUBJECT ORDER BY SUB_CODE";
    	String[] subs = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()) i++;
			subs=new String[i];
			i=0;
			//rs.beforeFirst();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				subs[i]=rs.getString("SUB_CODE");
				System.out.println(subs[i]);
				i++;
			}
			System.out.println(subs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return subs;}
    }
    
    public static String[] blks() {
    	String query="SELECT BLOCK_ID  FROM BLOCKK ORDER BY BLOCK_ID";
    	String[] bks = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()) i++;
			bks=new String[i];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
			while(rs.next()) {
				bks[i]=rs.getString("BLOCK_ID");
				System.out.println(bks[i]);
				i++;
			}
			System.out.println(bks);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return bks;}
    }
    
    public static String[] clrs() {
    	String query="SELECT CLASSROOM_ID  FROM CLASSROOM ORDER BY CLASSROOM_ID";
    	String[] clr = null;
    	try {
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()) i++;
			clr=new String[i];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
			while(rs.next()) {
				clr[i]=rs.getString("CLASSROOM_ID");
				System.out.println(clr[i]);
				i++;
			}
			System.out.println(clr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return clr;}
    }
    
    public static String[] classHandlers(String sec) {
    	String query="SELECT FACULTY_ID, SUB_CODE "+
    				 "FROM HANDLES "+
    				 "WHERE SEC_ID= \'"+sec+"\' AND BATCH_ID='ALL' "+
    				 "ORDER BY FACULTY_ID, SUB_CODE";
    	String hds[] = null;
    	System.out.println(query);
    	try {
    		ResultSet rs=stmt.executeQuery(query);
    		int i=0;
			while(rs.next()) i++;
			hds=new String[i];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
    		while(rs.next()) {
    			hds[i]="<html>"+rs.getString("FACULTY_ID")+"<br>"+rs.getString("SUB_CODE")+"</html>";
    			i++;
    		}
    		System.out.println(hds);
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {return hds;}
    }
    
    public static String[] labHandlers(String sec) {
    	String query="SELECT FACULTY_ID, SUB_CODE, BATCH_ID "+
    				 "FROM HANDLES "+
    				 "WHERE SEC_ID= \'"+sec+"\' AND BATCH_ID<>'ALL' "+
    				 "ORDER BY FACULTY_ID, SUB_CODE, BATCH_ID";
    	String hds[] = null;
    	System.out.println(query);
    	try {
    		ResultSet rs=stmt.executeQuery(query);
    		int i=0;
			while(rs.next()) i++;
			hds=new String[i];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
    		while(rs.next()) {
    			hds[i]="<html>"+rs.getString("FACULTY_ID")+", "+rs.getString("BATCH_ID")+"<br>"+rs.getString("SUB_CODE")+"</html>";
    			i++;
    		}
    		System.out.println(hds);
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {return hds;}
    }

    public static String[][] getTT(String faculty_id){
    	String query="SELECT SUB_CODE, SEC_ID, CLASSROOM_ID, BLOCK_ID, DAYY, TIMEE, DURATIONN"+
    				" FROM CLASS_OR_LAB"+
    				" WHERE FACULTY_ID='"+faculty_id+"'";
    	System.out.println(query);
    	String classes[][] = null;
    	System.out.println(query);
    
    	try {
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()) i++;
			classes=new String[i][7];
			i=0;
			rs=stmt.executeQuery(query);

			//rs.beforeFirst();
			//rs.getBoolean("SUB_CODE");
			//System.out.println(rs.next());
			while(rs.next()) {
				classes[i][0]=rs.getString("SUB_CODE");
				classes[i][1]=rs.getString("SEC_ID");
				classes[i][2]=rs.getString("CLASSROOM_ID");
				classes[i][3]=rs.getString("BLOCK_ID");
				classes[i][4]=rs.getString("DAYY");
				classes[i][5]=rs.getString("TIMEE");
				classes[i][6]=rs.getString("DURATIONN");
				System.out.println(classes[i][0]);
				System.out.println(classes[i][1]);
				System.out.println(classes[i][2]);
				System.out.println(classes[i][3]);
				System.out.println(classes[i][4]);
				System.out.println(classes[i][5]);
				System.out.println(classes[i][6]);
				i++;
			}
			System.out.println(classes);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return classes;}
    }
    
    public static String[][] getSecTT(String section_id){
    	String query="SELECT SUB_CODE,FACULTY_ID,CLASSROOM_ID,BLOCK_ID,DAYY,TIMEE,DURATIONN"+
				" FROM CLASS_OR_LAB"+
				" WHERE SEC_ID=\'"+section_id+"\'";
	String classes[][] = null;
	try {
		ResultSet rs=stmt.executeQuery(query);
		int i=0;
		while(rs.next()) i++;
		classes=new String[i][7];
		i=0;
		rs=stmt.executeQuery(query);
		//rs.beforeFirst();
		while(rs.next()) {
			classes[i][0]=rs.getString("SUB_CODE");
			classes[i][1]=rs.getString("FACULTY_ID");
			classes[i][2]=rs.getString("CLASSROOM_ID");
			classes[i][3]=rs.getString("BLOCK_ID");
			classes[i][4]=rs.getString("DAYY");
			classes[i][5]=rs.getString("TIMEE");
			classes[i][6]=rs.getString("DURATIONN");
			i++;
		}
		System.out.println(classes);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {return classes;}
}
    
    public static String[][] freeClassRooms(String day, String time){
    	String query="SELECT CLASSROOM_ID, HAS_PROJECTOR, BLOCK_ID"+
    				" FROM CLASSROOM"+
    				" WHERE CLASSROOM_ID IN ( (SELECT CLASSROOM_ID"+
    										" FROM CLASSROOM)"+
    										" MINUS"+
    										" (SELECT CLASSROOM_ID"+
    										" FROM CLASS_OR_LAB"+
    										" WHERE DAYY=\'"+day+"\' "+
    										" AND TIMEE=\'"+time+"\'))"+
    				"ORDER BY BLOCK_ID, CLASSROOM_ID";
    	String classr[][] = null;
    	System.out.println(query);
    	try {
    		ResultSet rs=stmt.executeQuery(query);
    		int i=0;
			while(rs.next()) i++;
			classr=new String[i][3];
			i=0;
			rs=stmt.executeQuery(query);
			//rs.beforeFirst();
    		while(rs.next()) {
    			classr[i][0]=rs.getString("CLASSROOM_ID");
    			classr[i][1]=rs.getString("HAS_PROJECTOR");
    			classr[i][2]=rs.getString("BLOCK_ID");
    			i++;
    		}
    		System.out.println(classr);
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {return classr;}
    }
    
    public static String deptOfFaculty(String f_id) {
    	String query="SELECT D.DEPT_NAME "+
    				 "FROM FACULTY F, DEPARTMENT D "+
    				 "WHERE F.DEPT_ID=D.DEPT_ID "+
    				 "AND F.FACULTY_ID=\'"+f_id+"\' ";
    	String dept=null;
    	try {
    		ResultSet rs=stmt.executeQuery(query);
    		if(rs.next()) {
				dept=rs.getString("DEPT_NAME");
			}
			System.out.println(dept);
    	}catch (SQLException e) {
			e.printStackTrace();
		}finally {return dept;}
    }
    
    public static String deptOfSection(String sec_id) {
    	String query="SELECT D.DEPT_NAME "+
				 	 "FROM FACULTY F, DEPARTMENT D , SECTION S "+
				 	 "WHERE F.DEPT_ID=D.DEPT_ID "+
				 	 "AND F.FACULTY_ID= S.FACULTY_ID "+
				 	 "AND S.SEC_ID=\'"+sec_id+"\' ";
    	String dept=null;
    	try {
    		ResultSet rs=stmt.executeQuery(query);
    		if(rs.next()) {
    			dept=rs.getString("DEPT_NAME");
    		}
    		System.out.println(dept);
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}finally {return dept;}
    }
    
    public static String classMentor(String sec_id) {
    	String query="SELECT F.FACULTY_NAME "+
			 	 "FROM FACULTY F, SECTION S "+
			 	 "WHERE F.FACULTY_ID= S.FACULTY_ID "+
			 	 "AND S.SEC_ID=\'"+sec_id+"\' ";
	String fname=null;
	try {
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next()) {
			fname=rs.getString("FACULTY_NAME");
		}
		System.out.println(fname);
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {return fname;}
    }
    
    public static String[][] subjAndHandlers(String sec_id){
    	String query="SELECT S.SUB_CODE, S.SUB_ABBREVATION, S.SUB_NAME, LISTAGG(H.FACULTY_ID, ', ') AS FACULTY_IDS "+
					" FROM HANDLES H, SUBJECT S"+
					" WHERE H.SUB_CODE=S.SUB_CODE"+
					" AND H.SEC_ID=\'"+sec_id+"\'"+
					" GROUP BY S.SUB_CODE, S.SUB_ABBREVATION, S.SUB_NAME ORDER BY S.SUB_CODE";
	String classr[][] = null;
	System.out.println(query);
	try {
		ResultSet rs=stmt.executeQuery(query);
		int i=0;
		while(rs.next()) i++;
		classr=new String[i][4];
		System.out.println(i);
		i=0;
		rs=stmt.executeQuery(query);
		//rs.beforeFirst();
		while(rs.next()) {
			classr[i][0]=rs.getString("SUB_CODE");
			classr[i][1]=rs.getString("SUB_ABBREVATION");
			classr[i][2]=rs.getString("SUB_NAME");
			classr[i][3]=rs.getString("FACULTY_IDS");
			i++;
			System.out.println(i);
		}
		System.out.println(classr);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {return classr;}
    }
    
    public static int delBlk(String blk_id) {
    	String sql="DELETE FROM BLOCKK WHERE BLOCK_ID=\'"+blk_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int delClassr(String classr_id) {
    	String sql="DELETE FROM CLASSROOM WHERE CLASSROOM_ID=\'"+classr_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int delDept(String dept_id) {
    	String sql="DELETE FROM DEPARTMENT WHERE DEPT_ID=\'"+dept_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int delFaculty(String f_id) {
    	String sql="DELETE FROM FACULTY WHERE FACULTY_ID=\'"+f_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int delSec(String sec_id) {
    	String sql="DELETE FROM SECTION WHERE SEC_ID=\'"+sec_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int delSub(String subcode) {
    	String sql="DELETE FROM SUBJECT WHERE SUB_CODE=\'"+subcode+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int delHandler(String f_id, String sec_id, String subcode) {
    	String sql="DELETE FROM HANDLES WHERE FACULTY_ID=\'"+f_id+"\' "+
    									"AND SEC_ID=\'"+sec_id+"\' "+
    									"AND SUB_CODE=\'"+subcode+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int delTT(String sec_id) {
    	String sql="DELETE FROM CLASS_OR_LAB WHERE SEC_ID=\'"+sec_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static String[] getBlk(String blk_id) {
    	String query="SELECT * FROM BLOCKK WHERE BLOCK_ID=\'"+blk_id+"\'";
    	String[] blk = new String[1];
    	try {
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				blk[0]=rs.getString("BLOCK_NAME");
			}
			System.out.println(blk);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return blk;}
    }
    
    public static String[] getClassr(String classr_id) {
    	String query="SELECT * FROM CLASSROOM WHERE CLASSROOM_ID=\'"+classr_id+"\'";
    	String[] classr = new String[2];
    	try {
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				classr[0]=rs.getString("HAS_PROJECTOR");
				classr[1]=rs.getString("BLOCK_ID");
			}
			System.out.println(classr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return classr;}
    }
    
    public static String[] getDept(String dept_id) {
    	String query="SELECT * FROM DEPARTMENT WHERE DEPT_ID=\'"+dept_id+"\'";
    	String[] dept = new String[1];
    	try {
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				dept[0]=rs.getString("DEPT_NAME");
			}
			System.out.println(dept);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return dept;}
    }
    
    public static String[] getFaculty(String f_id) {
    	String query="SELECT * FROM FACULTY WHERE FACULTY_ID=\'"+f_id+"\'";
    	String[] fac = new String[5];
    	try {
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				fac[0]=rs.getString("FACULTY_NAME");
				fac[1]=rs.getString("PH_NO");
				fac[2]=rs.getString("EMAIL");
				fac[3]=rs.getString("DESIGNATION");
				fac[4]=rs.getString("DEPT_ID");
			}
			System.out.println(fac);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return fac;}
    }
    
    public static String[] getSec(String sec_id) {
    	String query="SELECT * FROM SECTION WHERE SEC_ID=\'"+sec_id+"\'";
    	String[] sec = new String[4];
    	try {
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				sec[0]=rs.getString("SEC");
				sec[1]=rs.getString("SEM");
				sec[2]=rs.getString("ACADEMIC_YEAR");
				sec[3]=rs.getString("FACULTY_ID");
			}
			System.out.println(sec);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return sec;}
    }
    
    public static String[] getSub(String subcode) {
    	String query="SELECT * FROM SUBJECT WHERE SUB_CODE=\'"+subcode+"\'";
    	String[] sub = new String[2];
    	try {
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				sub[0]=rs.getString("DEPT_NAME");
				sub[1]=rs.getString("DEPT_ABBREVATION");
			}
			System.out.println(sub);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {return sub;}
    }

    public static int upBlk(String blk_id, String[] blk) {
    	String sql="UPDATE BLOCKK "+
    				"SET BLOCK_NAME = \'"+blk[0]+"\' "+
    				"WHERE BLOCK_ID=\'"+blk_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int upClassr(String classr_id, String[] classr) {
    	String sql="UPDATE CLASSROOM "+
    				"SET HAS_PROJECTOR=\'"+classr[0]+"\', BLOCK_ID=\'"+classr[1]+"\' "+
    				"WHERE CLASSROOM_ID=\'"+classr_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int upDept(String dept_id, String[] dept) {
    	String sql="UPDATE DEPARTMENT "+
    				"SET DEPT_NAME=\'"+dept[0]+"\' "+
    				"WHERE DEPT_ID=\'"+dept_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int upFaculty(String f_id, String[] f) {
    	String sql="UPDATE FACULTY "+
    				"SET FACULTY_NAME=\'"+f[0]+"\', PH_NO=\'"+f[1]+"\', EMAIL=\'"+f[2]+"\', DESIGNATION=\'"+f[3]+"\', DEPT_ID=\'"+f[4]+
    				"WHERE FACULTY_ID=\'"+f_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int upSec(String sec_id, String[] sec) {
    	String sql="UPDATE SECTION "+
    				"SET SEC=\'"+sec[0]+"\', SEM=\'"+sec[1]+"\', ACADEMIC_YEAR=\'"+sec[2]+"\', FACULTY_ID=\'"+sec[3]+"\' "+
    				"WHERE SEC_ID=\'"+sec_id+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }
    
    public static int upSub(String subcode, String[] sub) {
    	String sql="UPDATE SUBJECT "+
    				"SET SUB_NAME=\'"+sub[0]+"\', SUB_ABBREVATION=\'"+sub[1]+
    				"WHERE SUB_CODE=\'"+subcode+"\'";
    	int res=0;
    	try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			res=-1;
			e.printStackTrace();
		}finally { return res;}
    }

    public static void closeAll() {
    	try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
            e.printStackTrace();
        } 
        
    }
}
