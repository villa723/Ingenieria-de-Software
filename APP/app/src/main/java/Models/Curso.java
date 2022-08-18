package Models;

public class Curso {
    private String course_name;
    private String section;
    private String type;
    private String day;
    private String start;
    private String finish;
    private Integer id;

    public Curso(Integer _id,String _course_name,String _section,String _type, String _day,String _start,String _finish){
        this.id = _id;
        this.course_name = _course_name;
        this.section = _section;
        this.type = _type;
        this.day = _day;
        this.start = _start;
        this.finish = _finish;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getDay() {
        return day;
    }

    public String getFinish() {
        return finish;
    }

    public String getSection() {
        return section;
    }

    public String getStart() {
        return start;
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }
}
