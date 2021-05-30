package ru.af3412.forum.control;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.af3412.forum.Main;
import ru.af3412.forum.model.Post;
import ru.af3412.forum.model.User;
import ru.af3412.forum.service.PostService;
import ru.af3412.forum.service.UserService;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class ControlPostTest {

    @MockBean
    private PostService posts;

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "root", password = "secret", roles = "USER")
    public void shouldReturnPostMessage() throws Exception {
        this.mockMvc.perform(post("/posts/save")
                .param("name","Куплю ладу-грант. Дорого."))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).save(argument.capture());
        MatcherAssert.assertThat(argument.getValue().getName(), is("Куплю ладу-грант. Дорого."));
    }

    @Test
    @WithMockUser(username = "root", password = "secret", roles = "USER")
    public void shouldReturnRedirectToLogin() throws Exception {
        this.mockMvc.perform(post("/reg")
                .param("username","Test User")
                .param("password", "password"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(userService).save(argument.capture());
        MatcherAssert.assertThat(argument.getValue().getUsername(), is("Test User"));
    }


}
