/*
 * Copyright(C) 2005,  FPT University
 * J3.L.P0045
 * Timetable
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-23    1.0              TungCTHE141487      First Implement
 */
package entity;

/**
 * The class object of Classes, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Classes {

    /**
     * Information of classId
     */
    private int classId;
    /**
     * Information of className
     */
    private String className;

    /**
     * Constructor without parameter
     */
    public Classes() {
    }

    /**
     * Class constructor specifying classId, className of <code>Class</code>
     * object
     *
     * @param classId the classId of <code>Class</code> object, it is an int
     * @param className the className of <code>Class</code> object, it is a
     * string
     */
    public Classes(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    /**
     * Get value of classId attribute of <code>Class</code> object
     *
     * @return classId of <code>Class</code> object it is an int
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Set value of classId attribute of <code>Class</code> object
     *
     * @param classId is the classId of <code>Class</code>, it is an int
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * Get value of className attribute of <code>Class</code> object
     *
     * @return className of <code>Class</code> object it is a string
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set value of className attribute of <code>Class</code> object
     *
     * @param className is the className of <code>Class</code>, it is an int
     */
    public void setClassName(String className) {
        this.className = className;
    }

}
