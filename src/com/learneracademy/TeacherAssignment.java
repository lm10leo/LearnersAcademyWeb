package com.learneracademy;

public class TeacherAssignment {
    private int assignmentId;
    private String teacherFirstName;
    private String teacherLastName;
    private String className;
    private String subjectName;

    public TeacherAssignment(int assignmentId, String teacherFirstName, String teacherLastName, String className, String subjectName) {
        this.assignmentId = assignmentId;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.className = className;
        this.subjectName = subjectName;
    }

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getTeacherFirstName() {
		return teacherFirstName;
	}

	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}

	public String getTeacherLastName() {
		return teacherLastName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

    
}
