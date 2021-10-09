package ru.grokkers.invest.data.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.grokkers.invest.data.db.dao.StockDao
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.data.repository.StockRepository
import java.text.DecimalFormat
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

/**
 * @author Onanov Aleksey (@onanov)
 */
class StockRepositoryImpl @Inject constructor(private val dao: StockDao) : StockRepository {
    private val messages = listOf(
        "But I must explain to you how all this mistaken idea of denouncing pleasure ",
        "And praising pain was born and I will give you a complete account of",
        "The system, and expound the actual teachings of the great explorer of",
        "The truth, the master-builder of human happiness. No one rejects, dislikes,",
        "Or avoids pleasure itself, because it is pleasure, but because those who do not know",
        "How to pursue pleasure rationally encounter consequences that are extremely ",
        "Painful. Nor again is there anyone who loves or pursues or desires to obtain ",
        "Pain of itself, because it is pain, but because occasionally circumstances occur",
        "In which toil and pain can procure him some great pleasure. To take a trivial example,",
        "Which of us ever undertakes laborious physical exercise, except to obtain some advantage from it?",
        "But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying ",
        "Consequences, or one who avoids a pain that produces no resultant pleasure?"
    )
    override fun getAllStock(): Flow<List<Stock>> = flow<List<Stock>> {
        val random = Random(8800)
        messages.shuffled()
        repeat(10){ i ->
            emit(listOf(
                Stock(id = 1,name = "Pear (PER)",price = 125.20,message = messages[i],currencySymbol = "$" ),
                Stock(id = 2,name = "Scramsung (SCR)",price = random.nextDouble(200.0),message = messages[i],currencySymbol = "$" ),
                Stock(id = 3,name = "Hrenovo (LEN)",price = random.nextDouble(200.0),message = messages[i],currencySymbol = "$" ),
                Stock(id = 4,name = "Myasosay (MSI)",price = random.nextDouble(200.0),message = messages[i],currencySymbol = "$" ),
                Stock(id = 5,name = "SoberBank (Sob)",price = random.nextDouble(200.0),message = messages[i],currencySymbol = "$" ),
                Stock(id = 6,name = "OnanovCO (OCO)",price = random.nextDouble(200.0),message = "",currencySymbol = "$" ),
                Stock(id = 7,name = "WakeFuture (FUE)",price = random.nextDouble(200.0),message = messages[i],currencySymbol = "$" ),
                Stock(id = 8,name = "Barf (MSK)",price = random.nextDouble(200.0),message = messages[i],currencySymbol = "$" ),
                Stock(id = 9,name = "VodkaInside (VIE)",price = random.nextDouble(200.0),message = messages[i],currencySymbol = "$" ),
            ).sortedBy { it.price }.map { if (i==random.nextInt(1,9)) it.copy(price = random.nextDouble(200.0)) else it})
            delay(6000)
        }
    }.flowOn(Dispatchers.IO)

    override fun add(model: Stock) {

    }

    override fun add(list: List<Stock>) {
    }

    override fun update(model: Stock) {
    }

    override fun clear() {
    }
}