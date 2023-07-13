package com.example.APItest.testWithRetrofit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Controller
public class GitHubController {
    @GetMapping("/git")
    @ResponseBody
    public List<Repo>getReposForUser() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService=retrofit.create(GitHubService.class);
        return gitHubService.listRepo("Vacarciuc").execute().body();
    }
}
