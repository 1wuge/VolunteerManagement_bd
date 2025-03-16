package test;


import com.example.spring.service.VolunteerService;

public class test {

    public static void main(String[] args) {

        String a="吴";
        String b="%"+a;
        b+="%";

        System.out.println(VolunteerService.search(b));
    }

}

