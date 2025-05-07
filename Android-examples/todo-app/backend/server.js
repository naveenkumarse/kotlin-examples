const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();
const PORT = 3000;

const MONGO_URI = '';

mongoose.connect(MONGO_URI, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
.then(() => console.log('MongoDB connected ✅'))
.catch(err => console.error('MongoDB connection error:', err));

app.use(cors());
app.use(express.json());

// Mongoose schema and model
const TodoSchema = new mongoose.Schema({
  task: String
});

const Todo = mongoose.model('Todo', TodoSchema);

// Routes
app.get('/api/todo', async (req, res) => {
  const todos = await Todo.find();
  res.json(todos);
});

app.post('/api/todo', async (req, res) => {
  const { task } = req.body;
  const newTodo = new Todo({ task });
  await newTodo.save();
  res.json({ message: 'Task saved', todo: newTodo });
});

app.delete('/api/todo', async (req, res) => {
  const { task } = req.query;
  const result = await Todo.deleteOne({ task });
  res.json({ message: 'Task deleted', result });
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
