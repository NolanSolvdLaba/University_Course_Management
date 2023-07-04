    package org.example.model;
    
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import com.fasterxml.jackson.annotation.JsonRootName;
    
    import javax.xml.bind.annotation.*;
    
    @XmlRootElement(name = "course")
    @XmlAccessorType(XmlAccessType.FIELD)
    @JsonRootName("Course")
    public class Course {
    
        @JsonIgnore
        @XmlTransient
        private int courseId;
    
        @XmlElement(name = "course_name")
        @JsonProperty("courseName")
        private String courseName;
    
        @XmlElement(name = "credits")
        @JsonProperty("credits")
        private int credits;
    
        @XmlElement(name = "semester_id")
        @JsonProperty("semesterId")
        private int semesterId;
    
        @XmlElement(name = "instructor_id")
        @JsonProperty("instructorId")
        private int instructorId;
    
        @XmlElement(name = "department_id")
        @JsonProperty("departmentId")
        private int departmentId;
    
        @XmlElement(name = "classroom_id")
        @JsonProperty("classroomId")
        private int classroomId;
    
        @XmlElement(name = "description")
        @JsonProperty("description")
        private String description;
    
        public Course(String courseName, int credits, int semesterId, int instructorId, int departmentId, int classroomId, String description) {
            this.courseName = courseName;
            this.credits = credits;
            this.semesterId = semesterId;
            this.instructorId = instructorId;
            this.departmentId = departmentId;
            this.classroomId = classroomId;
            this.description = description;
        }

        public Course() {

        }

        public int getCourseId() {
            return courseId;
        }
    
        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
    
        public String getCourseName() {
            return courseName;
        }
    
        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
    
        public int getCredits() {
            return credits;
        }
    
        public void setCredits(int credits) {
            this.credits = credits;
        }
    
        public int getSemesterId() {
            return semesterId;
        }
    
        public void setSemesterId(int semesterId) {
            this.semesterId = semesterId;
        }
    
        public int getInstructorId() {
            return instructorId;
        }
    
        public void setInstructorId(int instructorId) {
            this.instructorId = instructorId;
        }
    
        public int getDepartmentId() {
            return departmentId;
        }
    
        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }
    
        public int getClassroomId() {
            return classroomId;
        }
    
        public void setClassroomId(int classroomId) {
            this.classroomId = classroomId;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        @Override
        public String toString() {
            return "Course{" +
                    "courseId=" + courseId +
                    ", courseName='" + courseName + '\'' +
                    ", credits=" + credits +
                    ", semesterId=" + semesterId +
                    ", instructorId=" + instructorId +
                    ", departmentId=" + departmentId +
                    ", classroomId=" + classroomId +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
