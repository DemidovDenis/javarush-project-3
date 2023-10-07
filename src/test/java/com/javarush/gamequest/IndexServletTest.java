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

@ExtendWith(MockitoExtension.class)
public class IndexServletTest {
    private final static String path = "/index.jsp";
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
    private IndexServlet indexServlet;
    @BeforeEach
    void setup() throws ServletException {
        when(config.getServletContext()).thenReturn(context);
        indexServlet.init(config);
    }

    /**
     * Тест проверяет, что RequestDispatcher перенаправляет по указанному пути.
     */
    @Test
    public void whenCallDoGet_ThenServlet_ReturnIndexPage() throws ServletException, IOException {
        when(context.getRequestDispatcher(path)).thenReturn(dispatcher);

        indexServlet.doGet(request,response);

        verify(context, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request,response);
    }
}
