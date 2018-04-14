package web.controller.common;

import core.commons.constant.RoleConstant;
import core.dao.common.AccountDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.common.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        AccountDao accountDao = daoFactory.getAccountDao();
        HttpSession session = req.getSession();
        String url = "";

        Account account = new Account();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        account.setUsername(username);
        account.setPassword(password);

        Account loginAccount = accountDao.login(account);
        if (loginAccount != null && loginAccount.getRole().getRole() == RoleConstant.CUSTOMER) {
            session.setAttribute("account", loginAccount);
            session.setAttribute("shoppingCart", null);
            url = "/views/fontend/home.jsp";
        } else {
            url = "/views/fontend/error.jsp";
        }
        resp.sendRedirect(url);
    }
}
