package project_erp.ui;

public enum DtoType {
	EMPLOYEE("사원 관리"), DEPARTMENT("부서 관리"), TITLE("직책 관리");
	
	final private String name;
    
    public String getName() {
        return name;
    }
 
    private DtoType(String name){
        this.name = name;
    }
	
}
