/*
 * Copyright (c) 2017. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jahirfiquitiva.libs.frames.fragments.base

import android.arch.persistence.room.Room
import jahirfiquitiva.libs.frames.models.db.FavoritesDao
import jahirfiquitiva.libs.frames.models.db.FavoritesDatabase
import jahirfiquitiva.libs.frames.utils.DATABASE_NAME

abstract class BaseFramesFragment<in T>:BaseViewModelFragment<T>() {
    private lateinit var database:FavoritesDatabase

    override fun onStart() {
        createDatabase()
        super.onStart()
    }

    fun createDatabase() {
        database = Room.databaseBuilder(context, FavoritesDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries().build()
    }

    fun getDatabase():FavoritesDao = database.favoritesDao()
}