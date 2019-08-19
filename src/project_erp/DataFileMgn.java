package project_erp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import project_erp.dto.Department;
import project_erp.dto.Employee;
import project_erp.dto.Title;

public class DataFileMgn {
	private String FILE_PATH = System.getProperty("user.dir") + "\\data\\";
	
	private List<Employee> empList;
	private List<Department> deptList;
	private List<Title> titleList;

	private File titleFile;
	private File deptFile;
	private File empFile;
	
	public DataFileMgn() {
		titleFile = new File(FILE_PATH + "titleFile.dat");
		deptFile = new File(FILE_PATH + "deptFile.dat");
		empFile = new File(FILE_PATH + "empFile.dat");
	}

	public void save() {
		File dataDir = new File(FILE_PATH);
		if (!dataDir.exists()) {
			System.out.println("data폴더가 없어서 생성하였습니다. ");
			dataDir.mkdir();
		}
		saveFile(titleFile, titleList);
		saveFile(deptFile, deptList);
		saveFile(empFile, empList);
	}
	
	public void load() {
		titleList = loadListToFile(titleFile);
		deptList = loadListToFile(deptFile);
		empList = loadListToFile(empFile);
		
		System.out.println(empList + "\n" + titleList + "\n" + deptList);
		
		if (deptList.size()==0) {
			System.out.println("deptList size=0");
			deptList.add(new Department(1, "개발", 3));
			deptList.add(new Department(2, "총무", 13));
			deptList.add(new Department(3, "인사", 30));
			deptList.add(new Department(4, "마케팅", 23));
		}
		
		if (titleList.size()==0) {
			System.out.println("titleList size=0");
			titleList.add(new Title(1, "사장"));
			titleList.add(new Title(2, "부장"));
			titleList.add(new Title(3, "과장"));
			titleList.add(new Title(4, "대리"));
		}
		
		if (empList.size() == 0) {
			System.out.println("empList size=0");
			empList.add(new Employee(1, "황기태", new Department(2, "총무", 13), new Title(1, "사장"), true,
					Arrays.asList("배구", "야구"), new Date(), "1234", 2000000));
		}
	}
	
	private void saveFile(File file, List<?> list) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			oos.writeObject(list);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> loadListToFile(File file) {
		List<T> itemList = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			itemList = (List<T>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (itemList == null) {
			itemList = new ArrayList<>();
		}
		return itemList;
	}

	@Override
	public String toString() {
		return String.format("DataFileMgn [empList=%s, deptList=%s, titleList=%s]", empList, deptList, titleList);
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public List<Department> getDeptList() {
		return deptList;
	}

	public List<Title> getTitleList() {
		return titleList;
	}

}
