package ru.bazunaka.bazbloglite.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Model.TweetAddRequest;
import ru.bazunaka.bazbloglite.Model.TweetEditRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Usecase.TweetAddCase;
import ru.bazunaka.bazbloglite.Usecase.TweetDeleteCase;
import ru.bazunaka.bazbloglite.Usecase.TweetEditCase;
import ru.bazunaka.bazbloglite.Usecase.TweetFindCase;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddCase tweetAddCase;
    private final TweetEditCase tweetEditCase;
    private final TweetDeleteCase tweetDeleteCase;
    private final TweetFindCase tweetFindCase;

    public TweetController(TweetAddCase tweetAddCase,
                           TweetEditCase tweetEditCase,
                           TweetDeleteCase tweetDeleteCase,
                           TweetFindCase tweetFindCase) {
        this.tweetAddCase = tweetAddCase;
        this.tweetEditCase = tweetEditCase;
        this.tweetDeleteCase = tweetDeleteCase;
        this.tweetFindCase = tweetFindCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid  @RequestBody TweetAddRequest addRequest) {
        return this.tweetAddCase.addTweet(addRequest);
    }

    @PutMapping
    public TweetResponse editTweet(@Valid  @RequestBody TweetEditRequest editRequest) {
        return this.tweetEditCase.editTweet(editRequest);
    }

    @DeleteMapping("/{tweetId}")
    public void deleteTweet(@PathVariable long tweetId) {
        this.tweetDeleteCase.deleteTweet(tweetId);
    }

    @GetMapping
    public Collection<TweetResponse> findOwnerTweets() {
        return this.tweetFindCase.findTweets();
    }
}
