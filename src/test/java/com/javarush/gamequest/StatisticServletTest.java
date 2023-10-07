package com.javarush.gamequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatisticServletTest {
    private final static String path = "/statistic.jsp";
    @Mock
    private ServletConfig config;
    @Mock
    private ServletContext context;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;
    @Spy
    private StatisticServlet staticServlet;
    @BeforeEach
    void setup() throws ServletException {
        when(config.getServletContext()).thenReturn(context);
        staticServlet.init(config);
    }

    /**
     * Тест проверяет, что RequestDispatcher перенаправляет по указанному пути.
     */
    @Test
    public void whenCallDoPost_ThenServlet_ReturnStaticPage() throws ServletException, IOException {
        when(context.getRequestDispatcher(path)).thenReturn(dispatcher);

        staticServlet.doPost(request,response);

        verify(context, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request,response);
    }
}