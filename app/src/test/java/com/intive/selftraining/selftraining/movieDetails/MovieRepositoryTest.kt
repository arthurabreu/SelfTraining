package com.intive.selftraining.selftraining.movieDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.model.Model
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MovieRepositoryTest {

    private val movieDetails = getMovieDetailsEntity()

    private val configuration = getConfigurationEntity()

//    private val url = imgUrl()

    var networkClient: NetworkInterface = mock {
        on { getMovieDetails(1) } doReturn getMovieDetailsEntity()
        on { getConfiguration() } doReturn getConfigurationEntity()
    }

    var testSchedulers: Schedulersssssss = mock {
        on { io() } doReturn Schedulers.trampoline()
        on { ui() } doReturn Schedulers.trampoline()
    }
    val tested = MovieRepository(networkClient, testSchedulers)

//    val showMovieDetailsObservable = mock<Observable<MovieDetailsEntitiy>> {
//        on { networkClient.getMovieDetails(335983) } doReturn it
//    }

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

//    @Before
//    fun setup() {
//        `when`(networkClient.getMovieDetails(335983))
//            .thenReturn(restAdapterBuilder)
//        `when`(restAdapterBuilder.setClient(any(OkClient::class.java)))
//            .thenReturn(restAdapterBuilder)
//    }

    @Test
    fun `should return MovieDetailsEntity when ask for getMovieDetails(id)`() {
//        var testObserver = NetworkClient().networkResponse.getMovieDetails(335983)
//        showMovieDetailsObservable.test()
//            .assertNoErrors()
//            .assertValue { l -> l.title == "Venom" }
//        testObserver = NetworkClient().networkResponse.getMovieDetails(424694)
//        testObserver.test()
//            .assertNoErrors()
//            .assertValue { l -> l.title == "Bohemian Rhapsody" }
    }

    @Test
    fun `should return title when ask for getMovieDetails(id)`() {

        tested.getMovieDetails(1).test().assertEmpty()
//        var testObserver = NetworkClient().networkResponse.getMovieDetails(335983)
//        showMovieDetailsObservable.test()
//            .assertNoErrors()
//            .assertValue { l -> l.title == "Venom" }
//        testObserver = NetworkClient().networkResponse.getMovieDetails(424694)
//        testObserver.test()
//            .assertNoErrors()
//            .assertValue { l -> l.title == "Bohemian Rhapsody" }
    }

//    @Test
//    fun `should return MovieDetailsEntity when ask for getMovieDetails(id)`() {
//        var testSubscribe = TestSubscriber<MovieDetailsEntitiy>()
//        var testObserver = NetworkClient().networkResponse.getMovieDetails(335983)
//        testObserver.test()
//            .assertNoErrors()
//            .assertValue { l -> l.title == "Venom" }
//        testObserver = NetworkClient().networkResponse.getMovieDetails(424694)
//        testObserver.test()
//            .assertNoErrors()
//            .assertValue { l -> l.title == "Bohemian Rhapsody" }
//
//    }

    @Test
    fun `should return ConfigurationEntity when ask for getConfiguration()`() {

//        val configurationObservable = Observable.just(configuration)
//
//        `when`(networkClient.getConfiguration()).thenReturn(configurationObservable)
//
//        networkClient.getConfiguration().test().assertValue(configuration)
    }

//    @Test
//    fun `should return image url after zip getConfiguration() and getMovieDetails(id)`() {
//
//        val urlCommon =
//            configuration.images.base_url + configuration.images.logo_sizes[0] + movieDetails.poster_path
//
//        urlCommon `should equal` url
//    }
//
//    private fun imgUrl(): String {
//        return getConfigurationEntity().images.base_url + getConfigurationEntity().images.logo_sizes[0] + getMovieDetailsEntity().poster_path
//    }

    private fun getMovieDetailsEntity(): Observable<MovieDetailsEntitiy> {

        return Observable.just(Model().getMovieDetailsEntity())
    }

    private fun getConfigurationEntity(): Observable<ConfigurationEntity> {

        return Observable.just(Model().getConfigurationEntity())
    }
}