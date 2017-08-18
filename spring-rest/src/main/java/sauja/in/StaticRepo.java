package sauja.in;

import sauja.in.api.entities.Users;

import java.util.ArrayList;
import java.util.List;

public class StaticRepo {
    private static List<Users> users;
    public static List<Users> getUsers()
    {
        if(users==null)
        {
            users=new ArrayList<Users>(10);
            for(int i=0;i<10;i++)
            {
                Users u = new Users();
                u.setEmail("email"+i+"@gmail.com");
                u.setFirstName("firstName"+i);
                u.setId(String.valueOf(i));
                u.setLastName("lastName"+i);
                users.add(u);

            }
        }
        return users;
    }
}
