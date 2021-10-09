package servlets.couponservlets;

import domain.Coupon;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class SetCouponServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        LocalDate beginDate = LocalDate.parse(req.getParameter("beginDate"));
        LocalDate finishDate = LocalDate.parse(req.getParameter("finishDate"));
        int percent = Integer.parseInt(req.getParameter("percent"));
        Coupon coupon = new Coupon(code,beginDate,finishDate,percent);
        ApplicationContext.getCouponServiceImpl().createOrUpdate(coupon);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/admin/AdminMainMenu.jsp");
        rd.forward(req,resp);
    }
}
