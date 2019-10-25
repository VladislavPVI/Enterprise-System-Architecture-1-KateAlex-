package com.labsKateAlex;

import com.labsKateAlex.bean.HobbyBean;
import com.labsKateAlex.domain.Hobby;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addHobby")
public class AddHobbyServlet extends HttpServlet {
    @EJB
    private HobbyBean hobbyBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("edit") != null) {
            long id = Long.valueOf(req.getParameter("edit"));
            Hobby hobby = hobbyBean.get(id);
            req.setAttribute("hobby", hobby);
        }
        req.getRequestDispatcher("/addHobby.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        int hoursperweek = Integer.valueOf(req.getParameter("hoursperweek"));
        int priority = Integer.valueOf(req.getParameter("priority"));

        if(!req.getParameter("id").equals("")) {
            long id = Long.valueOf(req.getParameter("id"));
            Hobby hobby = hobbyBean.get(id);
            hobby.setHoursperweek(hoursperweek);
            hobby.setName(name);
            hobby.setPriority(priority);
            hobbyBean.update(hobby);
        }
        else hobbyBean.add(new Hobby(name,hoursperweek,priority));
        resp.sendRedirect(req.getContextPath()+ "/start");
    }
}

