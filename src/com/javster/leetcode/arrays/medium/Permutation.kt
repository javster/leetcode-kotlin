class Permutation {
    fun permute(nums: IntArray): List<List<Int>> {
        return permutation(nums.toCollection(mutableListOf()))
    }

    private fun permutation(list: MutableList<Int>): MutableList<MutableList<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (list.size == 1) {
            result.add(mutableListOf(list.first()))
        } else {
            list.forEachIndexed { rootIndex, _ ->
                // Делаем поддерево без выбранного элемента - он становится корнем дерева
                val subtree = mutableListOf<Int>().apply {
                    addAll(list)
                    removeAt(rootIndex)
                }
                val permutations = permutation(subtree)
                // Добавляем ко всем перестановкам текущий выбранный элемент
                permutations.forEach { permutation ->
                    permutation.add(0, list[rootIndex])
                }
                result.addAll(permutations)
            }
        }
        return result
    }
}

fun main() {
    val test1 = intArrayOf(1,2,3)
    val test2 = intArrayOf(0,1)
    val solution = Solution()
    solution.permute(test2).forEach { permutation ->
        permutation.forEach { element ->
            print("$element ")
        }
        println()
    }
}