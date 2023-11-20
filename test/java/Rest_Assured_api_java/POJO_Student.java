package Rest_Assured_api_java;

public class POJO_Student {
    /*
    //Code Implementation
    {
        "course_name": "Programming Foundation Course",
            "duration": "3",
            "teacher_name1":"Ninja_1",
            "teachers_email1":"Ninja_1@gmail.com",
            "teacher_name2":"Ninja_2",
            "teacher_email2":"Ninja_2@gmail.com",
            "price": "2000"
    }
    */

        private String course_name;

        private int duration;
        private String teacher_name1;
        private String teacher_email1;
        private String teacher_name2;
        private String teacher_email2;
        private int price;


        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getTeacher_name1() {
            return teacher_name1;
        }

        public void setTeacher_name1(String teacher_name1) {
            this.teacher_name1 = teacher_name1;
        }

        public String getTeacher_email1() {
            return teacher_email1;
        }

        public void setTeacher_email1(String teacher_email1) {
            this.teacher_email1 = teacher_email1;
        }

        public String getTeacher_name2() {
            return teacher_name2;
        }

        public void setTeacher_name2(String teacher_name2) {
            this.teacher_name2 = teacher_name2;
        }

        public String getTeacher_email2() {
            return teacher_email2;
        }

        public void setTeacher_email2(String teacher_email2) {
            this.teacher_email2 = teacher_email2;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

};
//POJO_Student obj = new POJO_Student();



