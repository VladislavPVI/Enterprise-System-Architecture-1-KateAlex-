package com.labsKateAlex;

import com.labsKateAlex.bean.HobbyBean;
import com.labsKateAlex.bean.ScheduleBean;
import com.labsKateAlex.domain.Hobby;
import com.labsKateAlex.domain.Schedule;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/start")
public class MainServlet extends HttpServlet {
    @EJB
    private HobbyBean hobbyBean;
    @EJB
    private ScheduleBean scheduleBean;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hobby> allHobby = hobbyBean.getAll();
        req.setAttribute("allHobby",allHobby);
        List<Schedule> allSchedule = scheduleBean.getAll();
        req.setAttribute("allSchedule",allSchedule);
        req.setAttribute("now", DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.now()));
        ArrayList<String> allScheduleToday = new ArrayList<>();
        for (Schedule i : allSchedule)
            if(i.getLocalDateTime().toLocalDate().equals(LocalDate.now()))
                allScheduleToday.add("Хобби: " + hobbyBean.get(i.getHobbyid()).getName()+" Время: "+i.getLocalDateTime().toLocalTime());
        req.setAttribute("schedule_today",allScheduleToday);

        req.getRequestDispatcher("/start.jsp").forward(req,resp);

    }
}
