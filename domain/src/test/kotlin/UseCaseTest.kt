import com.ausom.domain.abstraction.FindrRepository
import com.ausom.domain.abstraction.PostExecutionThread
import com.ausom.domain.model.Photo
import com.ausom.domain.model.SearchPhotoParam
import com.ausom.domain.usecase.GetPhotos
import com.ausom.domain.usecase.LoadMorePhotos
import com.ausom.domain.usecase.SearchPhotos
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class UseCaseTest {

    @Test
    fun `GetPhotos gets photos from repository`() = runBlockingTest {
        //Given
        val expectedResult = emptyList<Photo>()
        val repository = mock<FindrRepository> {
            on { getPhotos() } doReturn flow { emit(expectedResult) }
        }
        val dispatcher = mock<PostExecutionThread> {
            on { io } doReturn TestCoroutineDispatcher()
        }
        val classUnderTest = GetPhotos(
            postExecutionThread = dispatcher,
            repository = repository
        )

        //When
        val result =  classUnderTest.invoke().first()

        //Then
        verify(repository).getPhotos()
        assert(result == expectedResult)
    }

    @Test
    fun `SearchPhotos search photos from repository`() = runBlockingTest {
        //Given
        val param = SearchPhotoParam(
            keyword = "flowers",
            page = 1
        )
        val expectedResult = Unit
        val repository = mock<FindrRepository> {
            on { searchPhotos(
                keyword = param.keyword,
                page = param.page
            ) } doReturn flow { emit(expectedResult) }
        }
        val dispatcher = mock<PostExecutionThread> {
            on { io } doReturn TestCoroutineDispatcher()
        }
        val classUnderTest = SearchPhotos(
            postExecutionThread = dispatcher,
            repository = repository
        )

        //When
        val result =  classUnderTest.invoke(param).first()

        //Then
        verify(repository).searchPhotos(param.keyword, param.page)
        assert(result == expectedResult)
    }

    @Test
    fun `LoadMorePhotos loads more photos from repository`() = runBlockingTest {
        //Given
        val expectedResult = Unit
        val repository = mock<FindrRepository> {
            on { loadMorePhotos() } doReturn flow { emit(expectedResult) }
        }
        val dispatcher = mock<PostExecutionThread> {
            on { io } doReturn TestCoroutineDispatcher()
        }
        val classUnderTest = LoadMorePhotos(
            postExecutionThread = dispatcher,
            repository = repository
        )

        //When
        val result =  classUnderTest.invoke().first()

        //Then
        verify(repository).loadMorePhotos()
        assert(result == expectedResult)
    }

}